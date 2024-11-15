import { FunctionalComponent } from "preact";

const Layout: FunctionalComponent = ({ children }) => {
    return <div class="flex flex-col w-screen h-screen bg-gray-100">
        <nav class=" bg-blue-500 p-4 shadow-md">
            <div class="container mx-auto flex justify-between items-center">
                <a href="/" class="text-white text-xl font-bold">Competition Site</a>
                <div>
                    <a href="/register" class="text-white mr-4 hover:underline">Tým</a>
                    <a href="/register" class="text-white mr-4 hover:underline">Zápasy</a>
                    <a href="/table-terms" class="text-white mr-4 hover:underline">Tabulka termínu</a>
                </div>
            </div>
        </nav>
        {children}
    </div>;
};

export default Layout;