export default {
    template:`
        <div class="card" style="margin-bottom: 1%">
            <div class="card-body">
            <form v-on:submit.prevent>
                <div class="mb-3"  >
                    <label>Question</label>
                    <input type="text" class="form-control" v-model="question" placeholder="Enter your question" required>
                </div>

                <div class="mb-3" >
                    <label>Answer</label>
                    <input type="text" class="form-control" v-model="answer" placeholder="Enter your answer" required>
                </div>
                <button type="save" class="btn btn-primary" v-if="id === 0" v-on:click="save()">Save</button>
                <button type="save" class="btn btn-primary" v-if="id !== 0" v-on:click="update(id)">Update</button>
            </form>
            </div>
        </div>

        <div class="card" v-if="formContent.length > 0">
            <table class="table" >
                <thead>
                    <tr>
                        <th scope="col">Question</th>
                        <th scope="col">Answer</th>
                        <th scope="col" width="10%">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="flashcards in formContent">
                        <td>{{flashcards.question}}</td>
                        <td>{{flashcards.answer}}</td>
                        <td style="vertical-align: middle">
                            <button type="button" class="btn btn-danger btn-sm" style="margin-right:1%" v-on:click="deleteCard(flashcards.id)">
                              <!-- trash icon in svg format -->
                              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                              </svg>
                            </button>
                            <button type="button" class="btn btn-primary btn-sm" v-on:click="editCard(flashcards)">
                                <!-- edit icon in svg format -->
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                                  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                                </svg>
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div v-else>
            There are no cards saved yet. 
        </div>
    `,
    data() {
        return {
            id: 0,
            question:"",
            answer:"",
            formContent:[],
        };
    },
    methods: {
        loadCardsInTable() {
            axios.get("/flashcards")
                .then(response => (this.formContent = response.data))
        },
        save() {
            if(this.question === "" || this.question.trim() === "" || this.answer === "" || this.answer.trim() === "") return;
            axios.post("/flashcards/save", {
                question: this.question,
                answer: this.answer
            })
                .then((repsonse) => {
                    this.question = "";
                    this.answer = "";
                    this.loadCardsInTable();
                }, (error) => {
                    console.log("Error: saving was not possible.")
                });
        },
        deleteCard(itemIndex){
            axios.delete("/flashcards/delete/"+ itemIndex)
                .then((response) =>{
                    this.loadCardsInTable();
                }, (error) =>{
                    console.log("Error: deleting was not possible.")
                })
        },
        //update mittels id
        editCard(flashcards){
            this.id = flashcards.id;
            this.question = flashcards.question;
            this.answer = flashcards.answer;
        },
        update(flashcards){
            if(this.question === "" || this.question.trim() === "" || this.answer === "" || this.answer.trim() === "") return;
            axios.put("/flashcards/update/" + flashcards.id,{
                id : this.id,
                question : this.question,
                answer : this.answer
            })
                .then((response) => {
                    this.question = "";
                    this.answer = "";
                    this.loadCardsInTable();
                    this.id = 0;
                }, (error) => {
                    console.log("Error: updating was not possible.")
            })
        }
    },
    mounted(){
        this.loadCardsInTable();
    }
}
