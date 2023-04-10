import {initializeApp} from "https://www.gstatic.com/firebasejs/9.12.1/firebase-app.js";
import {getAnalytics} from "https://www.gstatic.com/firebasejs/9.12.1/firebase-analytics.js";
import {getDatabase,ref,set,get,child,update,remove} from "https://www.gstatic.com/firebasejs/9.12.1/firebase-database.js"
import {getAuth,createUserWithEmailAndPassword } from "https://www.gstatic.com/firebasejs/9.12.1/firebase-auth.js";

const firebaseConfig = {
	apiKey: "AIzaSyAAJCo8idXrG-8z2KEvGDIBhde2eLd5cwY",
	authDomain: "nckhwithrealtimedatabases.firebaseapp.com",
	databaseURL: "https://nckhwithrealtimedatabases-default-rtdb.firebaseio.com",
	projectId: "nckhwithrealtimedatabases",
	storageBucket: "nckhwithrealtimedatabases.appspot.com",
	messagingSenderId: "778546586616",
	appId: "1:778546586616:web:de9bf43596dc44f087ec0d",
	measurementId: "G-TD0HDVBN8M"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
const database = getDatabase(app);

const auth = getAuth();

console.log("OK")


var btnLogin = document.getElementById("btnLogin");

var alertError = document.getElementById("alertError");

console.log("Ok");




/*-------------- End configuration -------------------- */




