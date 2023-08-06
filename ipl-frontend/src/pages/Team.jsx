import React, { useState } from "react";
import { useEffect } from "react";
import { Link, useParams } from "react-router-dom";
import axios from "axios";

export default function Team() {
  const { teamName } = useParams();
  const [val, setVal] = useState([]);
  useEffect(() => {
    axios
      .get(`http://localhost:8081/teams/${teamName}`)
      .then((res) => {
        console.log(res.data.matches);
        setVal(res.data.matches);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <div>
      Team - {teamName}
      {val.map((item, i) => {
        return (
          <div style={{ border: "1px solid black", margin: "5px" }}>
            Venue - {item.venue}
            <br />
            Date - {item.date}
            <br />
            Match - {item.matchNumber}
            {item.winningTeam === "${teamName}" ? (
              <p>{item.winningTeam}</p>
            ) : (
              <h5>Lost</h5>
            )}
            Toss - {item.tossWinner} -- Decision - {item.tossDecision}
          </div>
        );
      })}
      <Link to={`/teams/${teamName}/matches/season=2022`}>More</Link>
    </div>
  );
}
