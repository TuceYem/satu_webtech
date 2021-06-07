const app = Vue.createApp({});


app.component("flashcards",{
    template:`
        <div style="text-align: center">
            <p>
                Cards remaining: {{formContent.length}}
            </p>
            <div  v-if="this.formContent.length > 0">
                    <div class="card" style="margin-bottom: 1%;">
                        <div class="card-body">
                            <p style="font-size: x-large">
                                <strong>Question:</strong> 
                            </p>
                            <p style="font-size: large">
                                {{showContent(key).question}}
                            </p>
                            <button v-on:click="show = !show" type="button" class="btn btn-secondary">
                                Answer
                            </button>
                            <transition name="fade">
                                <p v-if="show">
                                    {{showContent(key).answer}}
                                </p>
                            </transition>
                        </div>
                    </div>
                <div>
                    <button type="button" class="btn btn-danger" style="float: left" v-on:click="checkOrderOfContent(); show=false">Again</button>
                    <button type="button" class="btn btn-success" style="float: right" v-on:click="deleteContentItem(key); show=false">Good</button>
                </div>
            </div>
            <p v-if="formContent.length === 0"> Good Job!</p>
        </div>
    `,
    data(){
        return{
            key:0,
            show: false,
            form:{
                question:"",
                answer:""
            },
            formContent:[
                {question: "okul", answer:"Schule"},
                {question: "chair", answer:"Stuhl"},
                {question: "desk", answer:"Schreibtisch"},
                {question: "kalem", answer:"Stift"},
                {question: "masa", answer:"Tisch"}
            ]
        };
    },
    methods: {
        showContent(indexContent) {
            return this.formContent[indexContent];
        },
        deleteContentItem(indexDelete) {
            //if last item of array then remove it with index "0" - otherwise delete current item with current index
            if (this.formContent.length === 1) {
                this.formContent.splice(0, 1);
            } else {
                this.formContent.splice(this.formContent[indexDelete], 1);
                this.checkOrderOfContent();
            }
        },
        checkOrderOfContent() {
            //when at the end of the array (length-1 because arrays start to count at 0) then reset key to 0 - otherwise iterate key
            this.key >= this.formContent.length - 1 ?
                this.key = 0 : this.key++;
        }
    }
});

app.mount("#flashcards-component");