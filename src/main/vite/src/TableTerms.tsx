import { FunctionComponent } from "preact";
import { useState, useEffect } from "preact/hooks";

const TableTerms: FunctionComponent = () => {
    const allMatches = [
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-13T18:00:00"), winner: "Team A", score: "3:0" },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-14T18:00:00"), winner: "Team B", score: "1:2" },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-15T18:00:00"), winner: "Team A", score: "2:1" },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-16T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-17T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-18T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-19T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-20T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-21T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-22T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-23T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-24T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-25T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-26T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-27T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-28T18:00:00") },
        { team1: "Team A", team2: "Team B", date: new Date("2024-11-29T18:00:00") },
    ];

    const [matches, setMatches] = useState<{ team1: string; team2: string; date: Date, winner?: string, score?: string }[]>([]);
    const [currentWeek, setCurrentWeek] = useState(new Date());

    useEffect(() => {
        const getWeekRange = (date: Date) => {
            const dayOfWeek = date.getDay();
            const startOfWeek = new Date(date);
            startOfWeek.setDate(date.getDate() - dayOfWeek + 1); // Monday
            const endOfWeek = new Date(date);
            endOfWeek.setDate(date.getDate() + (7 - dayOfWeek)); // Sunday
            return { startOfWeek, endOfWeek };
        };

        const { startOfWeek, endOfWeek } = getWeekRange(currentWeek);

        const upcomingMatches = allMatches.filter(match => 
            match.date >= startOfWeek && match.date <= endOfWeek
        );

        setMatches(upcomingMatches);
    }, [currentWeek]);

    const handlePreviousWeek = () => {
        const newDate = new Date(currentWeek);
        newDate.setDate(currentWeek.getDate() - 7);
        if (newDate < new Date()) {
            newDate.setDate(new Date().getDate() + 1);
        }
        setCurrentWeek(newDate);
    };

    const handleNextWeek = () => {
        const newDate = new Date(currentWeek);
        newDate.setDate(currentWeek.getDate() + 7);
    
        const lastMatchDate = new Date(Math.max(...allMatches.map(match => new Date(match.date).getTime())));
    
        if (newDate > lastMatchDate) {
            setCurrentWeek(lastMatchDate);
        } else {
            setCurrentWeek(newDate);
        }
    };

    return (
        <div class="flex flex-col items-center justify-center flex-grow">
            <style>
                {`
                    .custom-scrollbar::-webkit-scrollbar {
                        width: 8px;
                    }
                    .custom-scrollbar::-webkit-scrollbar-track {
                        background: #f1f1f1;
                        border-radius: 10px;
                    }
                    .custom-scrollbar::-webkit-scrollbar-thumb {
                        background: #888;
                        border-radius: 10px;
                    }
                    .custom-scrollbar::-webkit-scrollbar-thumb:hover {
                        background: #555;
                    }
                    .scrollbar-hide::-webkit-scrollbar {
                        display: none;
                    }
                    .scrollbar-hide {
                        -ms-overflow-style: none;  /* IE and Edge */
                        scrollbar-width: none;  /* Firefox */
                    }
                `}
            </style>
            <div class="bg-white p-8 rounded-lg shadow-lg max-w-md w-1/2">
                <h1 class="text-2xl font-bold mb-4 text-center">Tabulka termínu</h1>
                <div class="flex justify-between mb-4">
                    <button onClick={handlePreviousWeek} class="bg-blue-500 text-white p-2 rounded shadow-md hover:bg-blue-600">Předchozí týden</button>
                    <button onClick={handleNextWeek} class="bg-blue-500 text-white p-2 rounded shadow-md hover:bg-blue-600">Další týden</button>
                </div>
                <div class="flex flex-col space-y-2 overflow-y-auto max-h-96 custom-scrollbar">
                    {matches.map((match, index) => (
                        <div key={index} class="flex flex-col justify-between items-center bg-gray-200 p-4 rounded shadow">
                           <div class="flex justify-between w-full">
                                <span class={(match.winner && match.winner === match.team1) ? "text-lg font-semibold text-green-500" : (match.winner && match.winner !== match.team1) ? "text-lg font-semibold text-red-500" : "text-lg font-semibold"}>{match.team1}</span>
                                <span class="text-lg font-semibold">VS</span>
                                <span class={(match.winner && match.winner === match.team2) ? "text-lg font-semibold text-green-500" : (match.winner && match.winner !== match.team2) ? "text-lg font-semibold text-red-500" : "text-lg font-semibold"}>{match.team2}</span>
                            </div>
                            {new Date(match.date) < new Date() ? (
                                (match.winner === match.team1 || match.winner === match.team2) ? (
                                    <span class="text-sm text-gray-500">Výsledek: {match.score}</span>

                                ) : (
                                    <span class="text-sm text-gray-500">Nehráno</span>
                                )
                            ) : (
                                <span class="text-sm text-gray-500">{new Date(match.date).toLocaleDateString()} {new Date(match.date).toLocaleTimeString()}</span>
                            )}
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}

export default TableTerms;