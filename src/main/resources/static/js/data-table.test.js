function datatable(){
    return 2;
}

test("one plus one should be two", () => {
    expect(datatable()).toBe(2);
})