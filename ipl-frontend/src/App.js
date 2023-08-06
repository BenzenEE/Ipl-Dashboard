import { Route, Router, Routes } from "react-router-dom";
import "./App.css";
import Dashboard from "./pages/Dashboard";
import Team from "./pages/Team";
import MatchDetails from "./pages/MatchDetails";

function App() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/teams/:teamName" element={<Team />} />
        <Route
          path="/teams/:teamName/matches/:season"
          element={<MatchDetails />}
        />
      </Routes>
    </div>
  );
}

export default App;
