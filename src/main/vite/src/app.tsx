import {FunctionalComponent} from "preact";
import Home from "./Home";
import Router from "preact-router";

export const App: FunctionalComponent = () => {
    return (
        <Router>
            <Home path="/"/>
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
