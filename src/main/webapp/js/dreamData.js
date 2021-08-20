function loadData(what, btn) {
    if (what === "index") {
        requestData("dreamList.jsp?source=index", "list");
        console.log("index");
    } else if (what === "all") {
        if (btn === "delete") {
            console.log("delete");
            requestData("dreamList.jsp?source=all&btn=delete", "list");

        } else {
            requestData("dreamList.jsp?source=all", "list");
        }
        console.log("all");
    }
}