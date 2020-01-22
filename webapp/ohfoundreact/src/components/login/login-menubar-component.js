import React, { useState, useEffect } from "react";


function LoginMenubarComponent() {
  const [user, setUser] = useState({
      u_id: 0,
      u_name: "",
      is_verified: false,
      is_loggedin: false
  });

  const rightAlignedLoginGroup = {
        position: 'absolute', 
        right: 20, 
        display: 'inline-block', 
        margin: "25px",
        backgroundColor: "white"
  }

  const bttnStyle = {
      width: "70px"
  }

  const loginBttnHandler = () => {

  }

  const registerBttnHandler = () => {

  }
  
  return (
    <div style={rightAlignedLoginGroup}>
        <button style={bttnStyle} onClick={loginBttnHandler}>Login</button>
        <button style={bttnStyle} onClick={registerBttnHandler}>Register</button>
    </div>
  );
}

export default LoginMenubarComponent;