import { FunctionComponent } from "preact";
import { useState } from "preact/hooks";

const CreateTeam: FunctionComponent = () => {
    const [teamName, setTeamName] = useState("");
    const [teamAdmin, setTeamAdmin] = useState("");

    const handleSubmit = async (event: Event) => {
        event.preventDefault();

        const response = await fetch('/api/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ teamName, teamAdmin }),
        });

        if (response.ok) {
            console.log("Login successful");
        } else {
            console.error("Login failed");
        }
    };

    return (
        <div class="flex flex-col items-center justify-center flex-grow">
            <div class="bg-white p-8 rounded-lg shadow-lg max-w-md">
                <h1 class="text-2xl font-bold mb-6 text-center">Vytvořit tým</h1>
                <form class="flex flex-col" onSubmit={handleSubmit}>
                    <label for="username" class="mb-2 text-gray-700">Jméno týmu</label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        class="mb-4 p-2 border border-gray-300 rounded"
                        value={teamName}
                        onInput={(e) => setTeamName((e.target as HTMLInputElement).value)}
                    />
                    <label for="password" class="mb-2 text-gray-700">Admin</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        class="mb-6 p-2 border border-gray-300 rounded"
                        value={teamAdmin}
                        onInput={(e) => setTeamAdmin((e.target as HTMLInputElement).value)}
                    />
                    <button type="submit" class="bg-blue-500 text-white p-2 rounded shadow-md hover:bg-blue-600">Vytvořit tým</button>
                </form>
            </div>
        </div>
    );
}

export default CreateTeam;