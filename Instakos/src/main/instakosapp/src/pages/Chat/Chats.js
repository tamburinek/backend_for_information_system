import React, {useEffect, useState} from "react";
import AllChat from "../../components/AllChat";
import SendMessage from "../../components/SendMessage";

function Chats() {
return (
    <div>
        <AllChat/>
        <SendMessage/>
    </div>
);
}

export default Chats;
