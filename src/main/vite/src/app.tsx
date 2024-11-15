import {FunctionalComponent} from "preact";
import Home from "./Home";
import Login from "./Login";
import Register from "./Register";
import TableTerms from "./TableTerms";
import CreateTeam from "./CreateTeam";
import Team from "./Team";
import Router from "preact-router";
import Layout from "./Layout";

export const App: FunctionalComponent = () => {
    return (
        <Layout>
            <Router>
                <Home path="/"/>
                <Login path="/login"/>
                <Register path="/register"/>
                <TableTerms path="/table-terms"/>
                <Team path="/team"/>
                <CreateTeam path="/create-team"/>

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
                
        </Layout>
    );
};
