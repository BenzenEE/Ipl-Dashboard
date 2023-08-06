import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import axios from "axios";

export default function MatchDetails() {
  const { teamName, season } = useParams();
  const years = [
    2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019,
    2020, 2021, 2022,
  ];
  const [val, setVal] = useState([]);
  useEffect(() => {
    axios
      .get(`http://localhost:8081/teams/${teamName}/matches?${season}`)
      .then((res) => {
        console.log(res);
        setVal(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [season]);
  return (
    <div>
      {years.map((year, i) => {
        return (
          <>
            <Link
              to={`/teams/${teamName}/matches/season=${year}`}
              style={{ margin: "3px" }}
            >
              {year}
              {/* {setTime(year)} */}
            </Link>
            <br />
          </>
        );
      })}
      <div>
        {val.map((item, i) => {
          return (
            <div style={{ border: "1px solid black", margin: "3px" }}>
              Match - <b>{item.matchNumber}</b>
              <br />
              <b>{item.team1}</b> Vs. <b>{item.team2}</b>
              <br />
              Venue: <b>{item.venue}</b>
              <br />
              Winner: <b>{item.winningTeam}</b>
              <br />
              Toss: <b>{item.tossWinner}</b> ---- Decision:{" "}
              <b>{item.tossDecision}</b>
              <br />
              <b>{item.winningTeam}</b> Won by{" "}
              {item.wonBy === "Runs" ? (
                <b>{item.margin} Runs</b>
              ) : (
                <b>{item.margin} Wickets</b>
              )}
            </div>
          );
        })}
      </div>
    </div>
  );
}
