import { mount } from '@vue/test-utils'
import DataTable from './data-table.js'
global.axios = require("axios");


test("shows heading", () => {
    const wrapper = mount(DataTable);

    expect(wrapper.text()).toContain("There are no cards saved yet.");
})