import { FunctionComponent } from "preact";
import { useState } from "preact/hooks";

const Login: FunctionComponent = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = async (event: Event) => {
        event.preventDefault();

        const response = await fetch('/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, password }),
        });

        if (response.ok) {
            console.log("Login successful");
        } else {
            console.error("Login failed");
        }
    };

    return (
        <div class="flex flex-col items-center justify-center flex-grow">
            <div class="bg-gray-100 p-8 rounded-lg shadow-lg max-w-md">
                <h1 class="text-2xl font-bold mb-6 text-center">Login</h1>
                <form class="flex flex-col" onSubmit={handleSubmit}>
                    <label for="username" class="mb-2 text-gray-700">Uživatelské jméno</label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        class="mb-4 p-2 border border-gray-300 rounded"
                        value={username}
                        onInput={(e) => setUsername((e.target as HTMLInputElement).value)}
                    />
                    <label for="password" class="mb-2 text-gray-700">Heslo</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        class="mb-6 p-2 border border-gray-300 rounded"
                        value={password}
                        onInput={(e) => setPassword((e.target as HTMLInputElement).value)}
                    />
                    <button type="submit" class="bg-blue-500 text-white p-2 rounded shadow-md hover:bg-blue-600">Přihlásit</button>
                </form>
            </div>
        </div>
    );
}

export default Login;