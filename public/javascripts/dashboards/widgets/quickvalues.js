function addWidget_quickvalues(dashboardId, description, eventElem) {
    var params = originalUniversalSearchSettings();
    params.widgetType = "QUICKVALUES";

    params.field = eventElem.closest(".quickvalues").attr("data-field");

    if (!!eventElem.attr("data-stream-id")) {
        params.streamId = eventElem.attr("data-stream-id");
    }

    addWidget(dashboardId, description, params);
}

function updateWidget_quickvalues(widget, data) {
    var terms = data.result.terms;
    var total = data.result.total;

    var rows = $("table tbody", widget);

    // Reset all rows so we are not adding more and more on every reload.
    rows.html("");

    var sortedKeys = Object.keys(terms).sort(function(a,b){return terms[b] - terms[a]});

    for(var i = 0; i < sortedKeys.length; i++){
        var key = sortedKeys[i];
        var val = terms[key];
        var percent = (val/total*100);

        rows.append("<tr><td>" + htmlEscape(key) + "</td><td>" + percent.toFixed(2) + "</td><td>" + htmlEscape(val) + "</td></tr>");
    }

    $(".spinner", widget).hide();
    $(".quickvalues_widget-container", widget).show();

    // Scrolling for long tables.
    $(".quickvalues_widget-container", widget).nanoScroller();
}