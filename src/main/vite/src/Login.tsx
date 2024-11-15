import {FunctionComponent} from "preact";

const Login: FunctionComponent = () => {
    return (
        <div class="flex flex-col grow m-2 md:m-4 justify-center">
            <div>
            <h1>Login</h1>
            <form class="flex flex-col">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" />
                <label for="password">Password</label>
                <input type="password" id="password" name="password" />


                <button type="submit" class="bg-blue-500 text-white p-2 rounded">Login</button>
            </form> 
            </div>
            
        </div>
    )
}

export default Login;