
function loadData(what){
    if(what === "index"){
        requestData("dreamList.jsp?source=index", "list");
        console.log("index");
    }else if(what === "all"){
        console.log("all");
        requestData("dreamList.jsp?source=all", "list");
    }
}