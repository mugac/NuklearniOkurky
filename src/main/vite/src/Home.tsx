import {FunctionComponent} from "preact";

const Home: FunctionComponent = () => {
    return (
        <div class="flex flex-col grow m-2 md:m-4">
            <h1>Example Vite App</h1>
            <a href="/login" class="text-blue-500">Login</a>
        </div>
    )
}

export default Home;