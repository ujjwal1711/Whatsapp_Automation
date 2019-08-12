<%--
  Created by IntelliJ IDEA.
  User: aman
  Date: 13/12/18
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        window.fbAsyncInit = function() {
            // FB JavaScript SDK configuration and setup
            FB.init({
                appId: '2015383252115992', // FB App ID
                cookie: true,  // enable cookies to allow the server to access the session
                xfbml: true,  // parse social plugins on this page
                version: 'v2.8' // use graph api version 2.8
            });
            var t = {'<>':'div','html':'${id} '};
            FB.api('/me/posts?fields=likes.summary(true),shares,comments.summary(true)', {locale: 'en_US'},
                function (response) {
                    console.log(response.data);

                });
            var d=[
                {
                    "id": "722557471419551_649526912055941"
                },
                {
                    "id": "722557471419551_566168340391799"
                },
                {
                    "shares": {
                        "count": 1
                    },
                    "id": "722557471419551_527610497580917"
                },
                {
                    "id": "722557471419551_525131857828781",
                    "likes": {
                        "data": [
                            {
                                "id": "1748472345426142",
                                "name": "HackerEarth Bvcoe"
                            }
                        ],
                        "paging": {
                            "cursors": {
                                "before": "QVFIUlNzUFY5TzhZAbE43bnNyYmpiZA3NPY0VSUmZA1NG9NakcxTk51aXExWDFlUUZAkU1ctZAGJnMDZAuc3M0UHppTFY1Y1EwbjU2TnYzSllSanVHSHZApOHFfUjh3",
                                "after": "QVFIUmpzc2FSNDgwOFpJcWIzcXMzaG90MEtmNXV6M0E5Q2ZAYcjVyaU1NRXVYcmlGaHU4MDY0NG5hYUFESVdqSWlERzItR2xqR3dtakdIcDBvZAy1fcGg2QmhR"
                            }
                        }
                    }
                },
                {
                    "id": "722557471419551_490909867917647",
                    "comments": {
                        "data": [
                            {
                                "created_time": "2017-06-15T12:38:14+0000",
                                "from": {
                                    "name": "Aman Jain",
                                    "id": "722557471419551"
                                },
                                "message": "Yuvi Yuvraj tu toh chd me hi hain tere paas hi aayenge sab",
                                "id": "490909867917647_491048317903802"
                            }
                        ],
                        "paging": {
                            "cursors": {
                                "before": "WTI5dGJXVnVkRjlqZAFhKemIzSTZAORGt3T1RFeU5ERTBOVGcwTURVNU9qRTBPVGMxTURrM016WT0ZD",
                                "after": "WTI5dGJXVnVkRjlqZAFhKemIzSTZAORGt4TURRNE16RTNPVEF6T0RBeU9qRTBPVGMxTXpBeU9UUT0ZD"
                            }
                        }
                    }
                },
                {
                    "id": "722557471419551_462046284137339"
                },
                {
                    "id": "722557471419551_436374176704550"
                },
                {
                    "id": "722557471419551_425957534412881"
                },
                {
                    "id": "722557471419551_404285603246741"
                },
                {
                    "id": "722557471419551_396737680668200"
                },
                {
                    "id": "722557471419551_367373270271308"
                },
                {
                    "id": "722557471419551_365899220418713"
                },
                {
                    "id": "722557471419551_350278281980807"
                },
                {
                    "id": "722557471419551_327615557580413",
                    "likes": {
                        "data": [
                            {
                                "id": "722557471419551",
                                "name": "Aman Jain"
                            }
                        ],
                        "paging": {
                            "cursors": {
                                "before": "QVFIUkh4ZAWoyYTFVcG9pREY0SGhVb1YtYWstMkFlTHd6TU1rMlhTSTZAxT2N2emlOSk1vMU1vQmttUFlQSHpFUElaUFdVYmxVRWJfc2F6V3R5U29PcEFSVjd3",
                                "after": "QVFIUmgzaURrZA3VseFRYTTM2a2xsMjBvX1dyWXdockQ1N295a0JTaGJ0Rld3ekdkMlV2MFhqbXBCcEtGUXJ1SXAzUnpxM2ZAKTDhTdDlUSG9PMnNJT19ZAc3NB"
                            },
                            "next": "https://graph.facebook.com/v3.2/722557471419551_327615557580413/likes?access_token=EAADbDTSSwjMBAKRptXIRfic0JDHpK1TPbs5Otre1fIAVHGBZAwF9WKqTtSphi8UNcZBacbCjimzTwL5MkSU5MdZC9AxZAgCQBYLLpjIj45jypZA8y5HRuetcBvTQnnWDBOFRpUNyNbZCrnZBfUyRv0AGtDrua6gpWrQzGixutiRAEfZBXEpAGPfJzfvrv7GYs74ZD&pretty=0&limit=25&after=QVFIUmgzaURrZA3VseFRYTTM2a2xsMjBvX1dyWXdockQ1N295a0JTaGJ0Rld3ekdkMlV2MFhqbXBCcEtGUXJ1SXAzUnpxM2ZAKTDhTdDlUSG9PMnNJT19ZAc3NB"
                        }
                    }
                },
                {
                    "id": "722557471419551_254152904926679",
                    "comments": {
                        "data": [
                            {
                                "created_time": "2016-03-24T08:21:31+0000",
                                "from": {
                                    "name": "Aman Jain",
                                    "id": "722557471419551"
                                },
                                "message": "thanx bhaiya",
                                "id": "254152904926679_254559191552717"
                            }
                        ],
                        "paging": {
                            "cursors": {
                                "before": "WTI5dGJXVnVkRjlqZAFhKemIzSTZANalUwTlRVMk16WXhOVFV6TURBd09qRTBOVGc0TURjek56Yz0ZD",
                                "after": "WTI5dGJXVnVkRjlqZAFhKemIzSTZANalUxTWpBMU56a3hORGc0TURVM09qRTBOVGc0T0RRNU5EYz0ZD"
                            }
                        }
                    }
                },
                {
                    "id": "722557471419551_247005788974724"
                },
                {
                    "id": "722557471419551_216959278646042"
                },
                {
                    "id": "722557471419551_199660927042544",
                    "likes": {
                        "data": [
                            {
                                "id": "722557471419551",
                                "name": "Aman Jain"
                            }
                        ],
                        "paging": {
                            "cursors": {
                                "before": "QVFIUnR4eERzaVFabmtWcklFdE1YM2ZAuRHExX1FaNkxxdVFUakJGZAHBERkZALZAzBENXNENG42UGRuOFlDQWcxZA1pjTll5Y1JFdEN5Sk5wVDIyQnkwNUd4ZAnRB",
                                "after": "QVFIUmptR3E5WlVJa1ZAqS1ROdElBb0VrMzZAxOXB1Q25RYlV3MlRxSm5QbmxKd3Q0SHNtNzFrZAl9UX3F6Rms5eUc4YUEwanNISXo2eFhoNFJQX2tIajJ0TTZAB"
                            }
                        }
                    }
                }
            ];
            document.write( json2html.transform(d,t) );
        };

        (function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = "//connect.facebook.net/en_US/sdk.js";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));

    </script>
</head>

<body>
<script>


</script>
</body>
</html>
