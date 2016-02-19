
function submitQueryAll($scope, $http) {
    $http.get('localhost:8080/getall').
        success(function(data) {
            $scope.greeting = data;
        });
}

function fillMainTable(valueStr) {

	var htmlText = "<table BORDER=\"0\" CELLSPACING=\"1\" CELLPADDING=\"4\"><tr BGCOLOR=\"#EFEFEF\"><td align=\"CENTER\" bgcolor=\"#EFEFEF\" colspan=5><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"3\"color=\"#006699\">FESTIVITIES!</font></td></tr><tr BGCOLOR=\"#EFEFEF\"><td VALIGN=\"BOTTOM\" align=\"center\"><div align=\"center\"><b><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\"color=\"#006699\">Name</font></b></div></td><td VALIGN=\"BOTTOM\" align=\"center\"><div align=\"center\"><b><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\"color=\"#006699\">Start Date</font></b></div></td><td VALIGN=\"BOTTOM\" align=\"center\"><div align=\"center\"><b><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\"color=\"#006699\">End Date</font></b></div></td><td VALIGN=\"BOTTOM\" align=\"center\"><div align=\"center\"><b><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"1\"color=\"#006699\">Place</font></b></div></td><td bgcolor=\"#EFEFEF\">&nbsp;</td></tr>";

	// Replace by valueStr
	// "1|Jimmy's event|2016-02-22T19:16:01.001Z|2016-07-30T19:16:01.001Z|Jimmy's event&2|Craig's recognition|2015-10-27T14:01:09.009Z|2015-12-12T14:01:09.009Z|Craig's recognition&3|Edna's event|2015-11-09T18:28:16.016Z|2016-08-28T18:28:16.016Z|Edna's event&4|Howard's special time|2016-06-30T12:46:01.001Z|2016-07-02T12:46:01.001Z|Howard's special time&5|Catherine's event|2016-02-23T15:04:49.049Z|2016-05-22T15:04:49.049Z|Catherine's event&6|Valerie's recognition|2015-09-01T03:46:05.005Z|2016-07-16T03:46:05.005Z|Valerie's recognition&7|Clarence's event|2015-09-23T19:43:41.041Z|2016-02-10T19:43:41.041Z|Clarence's event&8|Keith's amazing days|2016-07-04T03:07:36.036Z|2017-06-10T03:07:36.036Z|Keith's amazing days&9|Amanda's event|2016-02-20T09:53:40.040Z|2016-12-19T09:53:40.040Z|Amanda's event&10|Karen's amazing days|2016-06-15T06:11:54.054Z|2017-01-27T06:11:54.054Z|Karen's amazing days&11|Ruth's event|2016-06-04T19:14:24.024Z|2017-03-01T19:14:24.024Z|Ruth's event&12|Barbara's amazing days|2015-12-01T05:41:42.042Z|2016-02-15T05:41:42.042Z|Barbara's amazing days&13|Charlie's event|2016-02-16T17:57:05.005Z|2017-01-08T17:57:05.005Z|Charlie's event&14|Pearl's event|2016-01-04T05:28:58.058Z|2016-10-26T05:28:58.058Z|Pearl's event&15|Lydia's special time|2016-07-09T23:18:55.055Z|2017-06-25T23:18:55.055Z|Lydia's special time&16|Allan's amazing days|2015-12-31T05:32:46.046Z|2016-09-10T05:32:46.046Z|Allan's amazing days&17|Willie's event|2016-05-16T08:56:54.054Z|2017-03-02T08:56:54.054Z|Willie's event&18|Erica's special time|2015-09-14T20:08:36.036Z|2016-02-16T20:08:36.036Z|Erica's special time&19|Heather's special time|2015-12-09T18:13:11.011Z|2016-09-16T18:13:11.011Z|Heather's special time&20|Vivian's amazing days|2016-02-20T17:52:12.012Z|2016-12-10T17:52:12.012Z|Vivian's amazing days&21|Chester's recognition|2016-05-23T07:45:26.026Z|2016-10-03T07:45:26.026Z|Chester's recognition&22|Tara's event|2016-03-06T16:41:27.027Z|2016-08-06T16:41:27.027Z|Tara's event&23|Robert's recognition|2015-10-29T12:05:59.059Z|2016-05-20T12:05:59.059Z|Robert's recognition&24|Adrian's recognition|2015-10-14T20:38:33.033Z|2016-10-01T20:38:33.033Z|Adrian's recognition&25|Sheila's event|2016-06-04T20:22:15.015Z|2016-07-28T20:22:15.015Z|Sheila's event&"
	var captionResult = "1|Jimmy's event|2016-02-22T19:16:01.001Z|2016-07-30T19:16:01.001Z|Jimmy's event&2|Craig's recognition|2015-10-27T14:01:09.009Z|2015-12-12T14:01:09.009Z|Craig's recognition&3|Edna's event|2015-11-09T18:28:16.016Z|2016-08-28T18:28:16.016Z|Edna's event&4|Howard's special time|2016-06-30T12:46:01.001Z|2016-07-02T12:46:01.001Z|Howard's special time&5|Catherine's event|2016-02-23T15:04:49.049Z|2016-05-22T15:04:49.049Z|Catherine's event&6|Valerie's recognition|2015-09-01T03:46:05.005Z|2016-07-16T03:46:05.005Z|Valerie's recognition&7|Clarence's event|2015-09-23T19:43:41.041Z|2016-02-10T19:43:41.041Z|Clarence's event&8|Keith's amazing days|2016-07-04T03:07:36.036Z|2017-06-10T03:07:36.036Z|Keith's amazing days&9|Amanda's event|2016-02-20T09:53:40.040Z|2016-12-19T09:53:40.040Z|Amanda's event&10|Karen's amazing days|2016-06-15T06:11:54.054Z|2017-01-27T06:11:54.054Z|Karen's amazing days&11|Ruth's event|2016-06-04T19:14:24.024Z|2017-03-01T19:14:24.024Z|Ruth's event&12|Barbara's amazing days|2015-12-01T05:41:42.042Z|2016-02-15T05:41:42.042Z|Barbara's amazing days&13|Charlie's event|2016-02-16T17:57:05.005Z|2017-01-08T17:57:05.005Z|Charlie's event&14|Pearl's event|2016-01-04T05:28:58.058Z|2016-10-26T05:28:58.058Z|Pearl's event&15|Lydia's special time|2016-07-09T23:18:55.055Z|2017-06-25T23:18:55.055Z|Lydia's special time&16|Allan's amazing days|2015-12-31T05:32:46.046Z|2016-09-10T05:32:46.046Z|Allan's amazing days&17|Willie's event|2016-05-16T08:56:54.054Z|2017-03-02T08:56:54.054Z|Willie's event&18|Erica's special time|2015-09-14T20:08:36.036Z|2016-02-16T20:08:36.036Z|Erica's special time&19|Heather's special time|2015-12-09T18:13:11.011Z|2016-09-16T18:13:11.011Z|Heather's special time&20|Vivian's amazing days|2016-02-20T17:52:12.012Z|2016-12-10T17:52:12.012Z|Vivian's amazing days&21|Chester's recognition|2016-05-23T07:45:26.026Z|2016-10-03T07:45:26.026Z|Chester's recognition&22|Tara's event|2016-03-06T16:41:27.027Z|2016-08-06T16:41:27.027Z|Tara's event&23|Robert's recognition|2015-10-29T12:05:59.059Z|2016-05-20T12:05:59.059Z|Robert's recognition&24|Adrian's recognition|2015-10-14T20:38:33.033Z|2016-10-01T20:38:33.033Z|Adrian's recognition&25|Sheila's event|2016-06-04T20:22:15.015Z|2016-07-28T20:22:15.015Z|Sheila's event&";

	var aditionalHTML = "";

	while (captionResult.length > 7) {
		var indexVar = captionResult.indexOf("&");
		var valString = "";
		if (indexVar != -1) {
			valString = captionResult.substring(0, indexVar);
			captionResult = captionResult.substring(indexVar + 1);

			var indexValVar = 0;

			indexValVar = valString.indexOf("|");
			var festId = valString.substring(0, indexValVar);
			valString = valString.substring(indexValVar + 1);

			indexValVar = valString.indexOf("|");
			var festName = valString.substring(0, indexValVar);
			valString = valString.substring(indexValVar + 1);

			indexValVar = valString.indexOf("|");
			var festStart = valString.substring(0, indexValVar);
			valString = valString.substring(indexValVar + 1);

			indexValVar = valString.indexOf("|");
			var festEnd = valString.substring(0, indexValVar);
			var festPlace = valString.substring(indexValVar + 1);

			aditionalHTML = aditionalHTML
					.concat("<tr><td bgcolor=\"#EFEFEF\"><input name=\"nameDataList"
							+ festId
							+ "\" id=\"nameDataList"
							+ festId
							+ "\" size=\"25\" value=\""
							+ festName
							+ "\"/></td><td bgcolor=\"#EFEFEF\"><input name=\"startDataList"
							+ festId
							+ "\" id=\"startDataList"
							+ festId
							+ "\" size=\"25\" value=\""
							+ festStart
							+ "\"/></td><td bgcolor=\"#EFEFEF\"><input name=\"endDataList"
							+ festId
							+ "\" id=\"endDataList"
							+ festId
							+ "\" size=\"25\" value=\""
							+ festEnd
							+ "\"/></td><td bgcolor=\"#EFEFEF\"><input name=\"placeDataList"
							+ festId
							+ "\" id=\"placeDataList"
							+ festId
							+ "\" size=\"25\" value=\""
							+ festPlace
							+ "\"/></td><td bgcolor=\"#EFEFEF\"><BUTTON TYPE=\"button\" value=\"Button\" style=\"BACKGROUND-COLOR: #006699\" onClick=\"updateFest("
							+ festId
							+ ");\"><font color=\"white\" face=\"univers 57 condense blanca\" size=\"1\"><B>Update</B></font></BUTTON></tr></tr>");
		}
	}

	htmlText = htmlText.concat(aditionalHTML);
	htmlText = htmlText.concat("</table>");
	document.getElementById("MainFestDiv").innerHTML = htmlText;
}