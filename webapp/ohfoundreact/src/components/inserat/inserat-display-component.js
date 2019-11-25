import React, { useState, useEffect } from "react";

// SERVICES
import inseratService from '../../services/inseratService';

function InseratDisplayComponent() {
  const [inserate, setInserate] = useState(null);

  useEffect(() => {
    if(!inserate) {
      getInserate();
    }
  })

  const getInserate = async () => {
    let res = await inseratService.getAllInserate();
    console.log("IN GET INSERATE: " + res);
    setInserate(res);
  }

  /*{ in_id, in_title, in_creationDate, in_typ, a_id, u_id, coordinates[], detailed_questions: []}*/
  const renderInserat = inserat => {
    return (
      <li key={inserat.in_id} className="list__item product">
        <h3 className="product__name">{inserat.in_title}</h3>
        <p className="product__description">{inserat.in_creationDate}</p>
        <p className="product__description">{inserat.in_typ}</p>
        <p className="product__description">{inserat.a_id}</p>
        <p className="product__description">{inserat.u_id}</p>
        <p className="product__description">{inserat.coordinates}</p>
        <p className="product__description">{inserat.detailed_questions}</p>
      </li>
    );
  };

  return (
    <div className="App">
      <ul className="list">
        {(inserate && inserate.length > 0) ? (
          inserate.map(inserat => renderInserat(inserat))
        ) : (
          <p>No inserate found</p>
        )}
      </ul>
    </div>
  );
}

export default InseratDisplayComponent;