import {FunctionComponent} from "preact";
import axios from "axios";

// Vytvářet token pro registraci, může jen admin teamu

const Team: FunctionComponent = () => {
    const testData = [
        {role: "Admin", name: "Petr Novák"},
        {role: "User", name: "Jan Novák"},
        {role: "User", name: "Jana Nováková"},
        {role: "User", name: "Petr Novák"},
        {role: "User", name: "Jan Novák"},
        {role: "User", name: "Jana Nováková"},
        {role: "User", name: "Jana Nováková"},
        {role: "User", name: "Jana Nováková"},
        {role: "User", name: "Jana Nováková"},
        {role: "User", name: "Jana Nováková"},
        {role: "User", name: "Jana Nováková"},
        {role: "User", name: "Jana Nováková"},
        {role: "User", name: "Jana Nováková"},
    ]

    const createRegisterLink = async () => {
        var name: string | null = window.prompt("Zadej jméno uživatele");

        axios.post("/api/create-login-link", {
            name: name
        }).then((response) => {
            console.log(response);
        }).catch((error) => {
            console.log(error);
        });
    };

    const deleteRegisteredUser = async () => {
        const response = await fetch('/api/register', {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({}),
        });

        if (response.ok) {
            console.log("User deleted");
        } else {
            console.error("User delete failed");
        }
    };

    const createTeam = async () => {

    };

    return (
        <div class="flex flex-col items-center justify-center bg-gray-100 my-14">
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
                    .table-container {
                        max-height: 16rem; /* max-h-64 */
                        overflow-y: auto;
                    }
                    .table-header {
                        position: sticky;
                        top: 0;
                        background: inherit;
                        z-index: 1;
                    }
                `}
            </style>
            <div class="bg-white p-8 rounded-lg shadow-lg max-w-2xl w-full">
                <h1 class="text-2xl font-bold mb-6 text-center">Tým</h1>
                <div class="table-container custom-scrollbar">
                    <table class="min-w-full bg-white">
                        <thead class="table-header">
                            <tr>
                                <th class="py-2 px-4 border-b border-gray-200 bg-gray-100 text-center text-sm font-semibold text-gray-700">Role</th>
                                <th class="py-2 px-4 border-b border-gray-200 bg-gray-100 text-center text-sm font-semibold text-gray-700">Jméno</th>
                            </tr>
                        </thead>
                        <tbody>
                            {testData.map((member, index) => (
                                <tr key={index}>
                                    <td class="py-2 px-4 border-b border-gray-200 text-sm">{member.role}</td>
                                    <td class="py-2 px-4 border-b border-gray-200 text-sm">{member.name}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
                <div class="flex ">
                    <button onClick={createRegisterLink} class="bg-blue-500 text-white p-2 rounded shadow-md hover:bg-blue-600 mt-5 mr-5">Vytořit uživatele</button>
                    <button onClick={deleteRegisteredUser} class="bg-blue-500 text-white p-2 rounded shadow-md hover:bg-blue-600 mt-5 mr-5">Smazat uživatele</button>
                    <a href="/create-team" class="bg-blue-500 text-white p-2 rounded shadow-md hover:bg-blue-600 mt-5 mr-5">Vytvořit team</a>
                </div>
            </div>
        </div>
    );
}

export default Team;