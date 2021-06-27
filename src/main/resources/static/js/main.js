import DataTable from "./data-table.js";
import FlashCard from "./flashcards.js";

const app = Vue.createApp({});
app.component("data-table", DataTable);
app.mount("#data-table-component");
app.component("flashcards", FlashCard);
app.mount("#flashcards-component");