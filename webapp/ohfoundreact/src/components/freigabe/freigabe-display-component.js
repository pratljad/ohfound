import React, { useState, useEffect } from "react";

// SERVICES
import freigabeService from '../../services/freigabeService';

function FreigabeDisplayComponent() {
  const [freigaben, setFreigaben] = useState(null);

  useEffect(() => {
    if(!freigaben) {
      getFreigaben();
    }
  })

  const getFreigaben = async () => {
    let res = await freigabeService.getAllFreigaben();
    console.log("IN GET INSERATE: " + res);
    setFreigaben(res);
  }

  /*f_id: 1, u_id: 1, in_id: 1, detailed_answers: [] ,is_resolved: false},*/
  const renderFreigabe = freigabe => {
    return (
      <li key={freigabe.f_id} className="list__item product">
        <h3 className="product__name">UID: {freigabe.u_id}</h3>
        <p className="product__description">IN_ID:{freigabe.in_id}</p>
        <p className="product__description">{freigabe.detailed_answers}</p>
        <p className="product__description">{freigabe.is_resolved}</p>
      </li>
    );
  };

  return (
    <div className="App">
      <ul className="list">
        {(freigaben && freigaben.length > 0) ? (
          freigaben.map(freigabe => renderFreigabe(freigabe))
        ) : (
          <p>No freigaben found</p>
        )}
      </ul>
    </div>
  );
}

export default FreigabeDisplayComponent;