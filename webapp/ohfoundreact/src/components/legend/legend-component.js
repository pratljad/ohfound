import React from "react";


function LegendComponent() {

  const alignLegendRightStyle = {
        position: 'absolute', 
        right: 0, 
        height: "16%",
        width: "14%",
        display: 'inline-block', 
        margin: "25px",
        backgroundColor: 'rgba(52, 52, 52, 0.3)'
  }

  const imageOpacity = {
      opacity: "1",
      display: 'inline-block'
  }

  const textStyle = {
      color: "white",
      display: 'inline-block'
  }
  return (
    <div style={alignLegendRightStyle}>
        <img src="/icons/marker_icon.svg" style={imageOpacity}></img><p style={textStyle}>- Locations</p><br />
        <img src="/icons/marker_icon_2.svg" style={imageOpacity}></img><p style={textStyle}>- Lost & Found Items</p>
  </div>
  );
}

export default LegendComponent;