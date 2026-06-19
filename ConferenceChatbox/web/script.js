// ==========================================
// WorkshopConnect Professional Edition
// ==========================================

// Initialize Storage

if (!localStorage.getItem("students")) {
    localStorage.setItem("students", JSON.stringify([]));
}

if (!localStorage.getItem("messages")) {
    localStorage.setItem("messages", JSON.stringify([]));
}

if (!localStorage.getItem("raisedHands")) {
    localStorage.setItem("raisedHands", JSON.stringify([]));
}

if (!localStorage.getItem("announcement")) {
    localStorage.setItem(
        "announcement",
        "No announcements yet."
    );
}

// ==========================================
// Host Login
// ==========================================

function hostLogin() {

    let username =
        document.getElementById(
            "hostUsername"
        ).value.trim();

    let password =
        document.getElementById(
            "hostPassword"
        ).value.trim();

    if (
        username === "host" &&
        password === "admin123"
    ) {

        localStorage.setItem(
            "hostActive",
            "true"
        );

        sessionStorage.setItem(
            "role",
            "host"
        );

        sessionStorage.setItem(
            "displayName",
            "HOST"
        );

        window.location.href =
            "chat.html";
    }

    else {

        alert(
            "Invalid Host Credentials"
        );
    }
}

// ==========================================
// Student Login
// ==========================================

function joinWorkshop() {

    let name =
        document.getElementById(
            "studentName"
        ).value.trim();

    let roll =
        document.getElementById(
            "studentRoll"
        ).value.trim();

    if (
        name === "" ||
        roll === ""
    ) {

        alert(
            "Please Fill All Fields"
        );

        return;
    }

    let students =
        JSON.parse(
            localStorage.getItem(
                "students"
            )
        );

    if (
        students.length >= 100
    ) {

        alert(
            "Workshop Full (100 Participants)"
        );

        return;
    }

    let anonymousId =
        "Student-" +
        (students.length + 1);

    let student = {

        anonymousId: anonymousId,

        name: name,

        roll: roll,

        joinTime:
            new Date()
            .toLocaleString()

    };

    students.push(student);

    localStorage.setItem(
        "students",
        JSON.stringify(students)
    );

    sessionStorage.setItem(
        "role",
        "student"
    );

    sessionStorage.setItem(
        "displayName",
        anonymousId
    );

    addSystemMessage(
        anonymousId +
        " joined workshop"
    );

    window.location.href =
        "chat.html";
}

// ==========================================
// System Messages
// ==========================================

function addSystemMessage(text) {

    let messages =
        JSON.parse(
            localStorage.getItem(
                "messages"
            )
        );

    messages.push({

        sender: "SYSTEM",

        text: text,

        type: "system",

        time:
            new Date()
            .toLocaleTimeString()

    });

    localStorage.setItem(
        "messages",
        JSON.stringify(messages)
    );
}
// ==========================================
// Send Message
// ==========================================

function sendMessage() {

    let input =
        document.getElementById(
            "messageInput"
        );

    if (!input) {
        return;
    }

    let text =
        input.value.trim();

    if (text === "") {
        return;
    }

    let messages =
        JSON.parse(
            localStorage.getItem(
                "messages"
            )
        );

    messages.push({

        sender:
            sessionStorage.getItem(
                "displayName"
            ),

        text: text,

        type:
            sessionStorage.getItem(
                "role"
            ),

        time:
            new Date()
            .toLocaleTimeString()

    });

    localStorage.setItem(
        "messages",
        JSON.stringify(messages)
    );

    input.value = "";

    loadMessages();
}

// ==========================================
// Load Messages
// ==========================================

function loadMessages() {

    let chatBox =
        document.getElementById(
            "chatBox"
        );

    if (!chatBox) {
        return;
    }

    let messages =
        JSON.parse(
            localStorage.getItem(
                "messages"
            )
        );

    chatBox.innerHTML = "";

    messages.forEach(function(msg) {

        let div =
            document.createElement(
                "div"
            );

        div.classList.add(
            "message"
        );

        if (
            msg.type === "host"
        ) {

            div.classList.add(
                "host-message"
            );
        }

        else if (
            msg.type === "student"
        ) {

            div.classList.add(
                "student-message"
            );
        }

        else {

            div.classList.add(
                "system-message"
            );
        }

        div.innerHTML =

            "<b>" +
            msg.sender +
            "</b><br>" +

            msg.text +

            "<br><small>" +

            msg.time +

            "</small>";

        chatBox.appendChild(div);
    });

    chatBox.scrollTop =
        chatBox.scrollHeight;
}

// ==========================================
// Announcement System
// ==========================================

function sendAnnouncement() {

    if (
        sessionStorage.getItem(
            "role"
        ) !== "host"
    ) {
        return;
    }

    let input =
        document.getElementById(
            "announcementInput"
        );

    if (!input) {
        return;
    }

    let text =
        input.value.trim();

    if (text === "") {
        return;
    }

    localStorage.setItem(
        "announcement",
        text
    );

    addSystemMessage(
        "New Announcement Posted"
    );

    input.value = "";

    loadAnnouncement();
}

function loadAnnouncement() {

    let box =
        document.getElementById(
            "announcementBox"
        );

    if (!box) {
        return;
    }

    box.innerHTML =
        localStorage.getItem(
            "announcement"
        );

    let controls =
        document.getElementById(
            "hostAnnouncementControls"
        );

    if (
        controls &&
        sessionStorage.getItem(
            "role"
        ) !== "host"
    ) {

        controls.style.display =
            "none";
    }
}

// ==========================================
// Raise Hand Feature
// ==========================================

function raiseHand() {

    let user =
        sessionStorage.getItem(
            "displayName"
        );

    let hands =
        JSON.parse(
            localStorage.getItem(
                "raisedHands"
            )
        );

    if (
        !hands.includes(user)
    ) {

        hands.push(user);

        localStorage.setItem(
            "raisedHands",
            JSON.stringify(hands)
        );

        addSystemMessage(
            user +
            " raised hand"
        );
    }
}

function loadRaisedHands() {

    let box =
        document.getElementById(
            "raiseHandList"
        );

    if (!box) {
        return;
    }

    box.innerHTML = "";

    let hands =
        JSON.parse(
            localStorage.getItem(
                "raisedHands"
            )
        );

    hands.forEach(function(user) {

        box.innerHTML +=

            "<div class='online-user'>✋ " +

            user +

            "</div>";
    });
}
// ==========================================
// Participants List
// ==========================================

function loadParticipants() {

    let users =
        document.getElementById(
            "onlineUsers"
        );

    if (!users) {
        return;
    }

    users.innerHTML = "";

    let students =
        JSON.parse(
            localStorage.getItem(
                "students"
            )
        );

    students.forEach(function(student) {

        users.innerHTML +=

            "<div class='online-user'>" +

            student.anonymousId +

            "</div>";
    });

    let participantCount =
        document.getElementById(
            "participantCount"
        );

    if (
        participantCount
    ) {

        participantCount.innerHTML =
            students.length;
    }
}

// ==========================================
// Statistics Dashboard
// ==========================================

function updateStatistics() {

    let messages =
        JSON.parse(
            localStorage.getItem(
                "messages"
            )
        );

    let countBox =
        document.getElementById(
            "messageCountDisplay"
        );

    if (
        countBox
    ) {

        countBox.innerHTML =
            messages.length;
    }
}

// ==========================================
// Host Dashboard
// ==========================================

function loadHostDashboard() {

    let dashboard =
        document.getElementById(
            "hostDashboard"
        );

    let table =
        document.getElementById(
            "studentTable"
        );

    if (
        !dashboard ||
        !table
    ) {
        return;
    }

    let role =
        sessionStorage.getItem(
            "role"
        );

    if (
        role !== "host"
    ) {

        dashboard.style.display =
            "none";

        return;
    }

    let students =
        JSON.parse(
            localStorage.getItem(
                "students"
            )
        );

    table.innerHTML = "";

    students.forEach(function(student) {

        let row =
            document.createElement(
                "tr"
            );

        row.innerHTML =

            "<td>" +
            student.anonymousId +
            "</td>" +

            "<td>" +
            student.name +
            "</td>" +

            "<td>" +
            student.roll +
            "</td>" +

            "<td>" +
            student.joinTime +
            "</td>";

        table.appendChild(row);
    });
}

// ==========================================
// Export Attendance CSV
// ==========================================

function exportAttendance() {

    let students =
        JSON.parse(
            localStorage.getItem(
                "students"
            )
        );

    let csv =

        "Anonymous ID,Name,Roll Number,Join Time\n";

    students.forEach(function(student) {

        csv +=

            student.anonymousId + "," +

            student.name + "," +

            student.roll + "," +

            student.joinTime +

            "\n";
    });

    let blob =
        new Blob(
            [csv],
            {
                type:
                "text/csv"
            }
        );

    let link =
        document.createElement(
            "a"
        );

    link.href =
        URL.createObjectURL(
            blob
        );

    link.download =
        "Workshop_Attendance.csv";

    link.click();
}

// ==========================================
// Current User
// ==========================================

function loadCurrentUser() {

    let user =
        document.getElementById(
            "currentUser"
        );

    if (!user) {
        return;
    }

    user.innerHTML =

        "Logged In As : " +

        sessionStorage.getItem(
            "displayName"
        );
}

// ==========================================
// Logout
// ==========================================

function logout() {

    let user =
        sessionStorage.getItem(
            "displayName"
        );

    addSystemMessage(

        user +

        " left workshop"
    );

    sessionStorage.clear();

    window.location.href =
        "index.html";
}

// ==========================================
// Enter Key Support
// ==========================================

document.addEventListener(
    "keydown",
    function(event) {

        if (
            event.key === "Enter"
        ) {

            let messageBox =
                document.getElementById(
                    "messageInput"
                );

            if (
                messageBox &&
                document.activeElement ===
                messageBox
            ) {

                sendMessage();
            }
        }
    }
);

// ==========================================
// Auto Refresh
// ==========================================

setInterval(function() {

    loadMessages();

    loadParticipants();

    loadHostDashboard();

    loadRaisedHands();

    loadAnnouncement();

    updateStatistics();

}, 1000);

// ==========================================
// Page Load
// ==========================================

window.onload = function() {

    loadMessages();

    loadParticipants();

    loadHostDashboard();

    loadRaisedHands();

    loadAnnouncement();

    updateStatistics();

    loadCurrentUser();
};