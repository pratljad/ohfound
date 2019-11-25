import React, { useState, useEffect } from "react";


function SearchBarComponent () {
    const mySBStyle = {
        width: "50%"
    };
    return (
        <div>
            <input type="search" style={mySBStyle} placeholder="Search..." />
        </div>
    );
}

export default SearchBarComponent;