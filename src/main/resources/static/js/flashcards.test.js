import {shallowMount, mount } from '@vue/test-utils'
import FlashCard from './flashcards.js'
global.axios = require("axios");


test("shows heading", () => {
    var wrapper = mount(FlashCard);

    expect(wrapper.text()).toContain("Cards remaining: 0");
})


describe('FlashCard', () => {
    it('renders a message and responds correctly to user input', () => {
        let wrapper = shallowMount(FlashCard, {
            data() {
                return {
                    formContent:[
                        {question: "school", answer:"Schule"},
                        {question: "chair", answer:"Stuhl"},
                        {question: "desk", answer:"Schreibtisch"},
                        {question: "red", answer:"rot"},
                        {question: "blue", answer:"blau"}
                        ]
                }
            }
        })
        //can load every card and count the amount
        expect(wrapper.text()).toContain("Cards remaining: 5");
    })
})