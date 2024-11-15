import { FunctionComponent } from "preact";

// Vytvářet token pro registraci, může jen admin teamu

const Register: FunctionComponent = () => {
    return (
        <div class="flex flex-col items-center justify-center">
            <div class="bg-gray-100 p-8 rounded-lg shadow-lg max-w-md">
                <h1 class="text-2xl font-bold mb-6 text-center">Register</h1>
                <form class="flex flex-col">
                    <label for="username" class="mb-2 text-gray-700">Username</label>
                    <input type="text" id="username" name="username" class="mb-4 p-2 border border-gray-300 rounded" />
                    <label for="password" class="mb-2 text-gray-700">Password</label>
                    <input type="password" id="password" name="password" class="mb-6 p-2 border border-gray-300 rounded" />
                    <button type="submit" class="bg-blue-500 text-white p-2 rounded shadow-md hover:bg-blue-600">Register</button>
                </form>
            </div>
        </div>
    );
}

export default Register;