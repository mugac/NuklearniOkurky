import {FunctionalComponent} from "preact";
import Home from "./Home";
import Login from "./Login";
import Router from "preact-router";

export const App: FunctionalComponent = () => {
    return (
        <Router>
            <Home path="/"/>
            <Login path="/login"/>
            {/* <AsyncRoute
                path="/friends"
                getComponent={() => import('./friends').then(module => module.default)}
            />
            <AsyncRoute
                path="/friends/:id"
                getComponent={() => import('./friend').then(module => module.default)}
                loading={() => <div>loading...</div>}
            /> */}
        </Router>
    );
};
