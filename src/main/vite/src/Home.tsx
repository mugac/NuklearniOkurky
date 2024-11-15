import { FunctionComponent } from "preact";

const Home: FunctionComponent = ({children}) => {
    return (
        <div class="flex flex-col items-center justify-center flex-grow">
            <div class="text-center p-8 bg-white rounded-lg shadow-lg max-w-2xl">
                <h2 class="text-4xl font-bold mb-6">Vítám tě na portále volejbalové soutěže</h2>
                <p class="text-lg mb-6">
                    Pokud jsi už zaregistrovaný v teamu, prosím přihlaš se. 
                    Pokud ještě nemáš účet, kontakuj svého trenéra.
                </p>
                <a href="/login" class="bg-blue-500 text-white p-4 rounded shadow-md hover:bg-blue-600">
                    Přejít na přihlášní
                </a>
            </div>
        </div>
    );
}

export default Home;