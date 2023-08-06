import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function Dashboard() {
  const [teams, setTeams] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:8081/teams")
      .then((res) => {
        console.log(res.data);
        setTeams(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <div style={{ display: "flex", flexWrap: "wrap" }}>
      {teams.map((team, i) => {
        return (
          <Link to={`/teams/${team.teamName}`}>
            <div
              style={{
                border: "1px solid black",
                justifyContent: "center",
                margin: "5px",
              }}
            >
              <h3>{team.teamName}</h3>
              <h4>Total Matches - {team.totalMatches} </h4>
              <h4>Total Wins - {team.totalWins} </h4>
            </div>
          </Link>
        );
      })}
    </div>
  );
}
