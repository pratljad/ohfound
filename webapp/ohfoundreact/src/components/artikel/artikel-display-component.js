import React, { useState, useEffect } from "react";

// SERVICES
import artikelService from '../../services/artikelService';

function ArtikelDisplayComponent() {
  const [artikels, setArtikel] = useState(null);

  useEffect(() => {
    if(!artikels) {
      getArtikels();
    }
  })

  const getArtikels = async () => {
    let res = await artikelService.getAllArtikel();
    console.log(res);
    setArtikel(res);
  }

  /*{ a_id: 1, a_description: "iPhone 6S+", a_type: "Mobile"},*/
  const renderArtikels = artikel => {
    return (
      <li key={artikel.a_id} className="list__item product">
        <h3 className="product__name">A DESC: {artikel.a_description}</h3>
        <p className="product__description">A TYP:{artikel.a_type}</p>
      </li>
    );
  };

  return (
    <div className="App">
      <ul className="list">
        {(artikels && artikels.length > 0) ? (
          artikels.map(artikel => renderArtikels(artikel))
        ) : (
          <p>No artikels found</p>
        )}
      </ul>
    </div>
  );
}

export default ArtikelDisplayComponent;