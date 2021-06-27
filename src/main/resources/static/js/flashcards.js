export default{
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
                                {{formContent[key].question}}
                            </p>
                            <button v-on:click="show = !show" type="button" class="btn btn-secondary">
                                Answer
                            </button>
                            <transition name="fade">
                            <p v-if="show">
                                {{formContent[key].answer}} 
                            </p>
                            </transition>
                        </div>
                    </div>
                <div>
                    <button type="button" class="btn btn-danger" style="float: left" v-on:click="checkOrderOfContent(); show=false">Again</button>
                    <button type="button" class="btn btn-success" style="float: right" v-on:click="deleteContentItem(); show=false">Good</button>
                </div>
            </div>
            <div v-if="formContent.length === 0 && loaded === true">
                <p style="font-size: large">
                  GOOD JOB!
                </p>
                <p>
                  Add new cards in the 'Edit' tab or restart by refreshing the browser.
                </p>
                <img src="images/result.png" />
            </div>
        </div>
    `,
    data(){
        return{
            key:0,
            show: false,
            //load v-if after data was loaded https://stackoverflow.com/questions/62830286/how-to-wait-until-data-is-loaded-for-showing-this-v-if-condition-correctly-in-vu
            loaded: false,
            formContent:[]
        };
    },
    methods: {
        deleteContentItem() {
                //if last item of array then remove it with index - iterate when possible
                this.formContent.splice(this.key, 1);
                if(this.key >= this.formContent.length-1) this.key = 0;
        },
        checkOrderOfContent() {
            //when at the end of the array (length-1 because arrays start to count at 0) then reset key to 0 - otherwise iterate key
            console.log(this.key);
            if(this.key >= this.formContent.length-1) {
                this.key = 0;
            }else{
                this.key++;
            }
        },
        loadCardsInTable() {
            axios.get("/flashcards")
                .then(response => (
                    this.formContent = response.data,
                    this.loaded = true
                ))
        },
    },
    mounted(){
        this.loadCardsInTable();
    }
}
