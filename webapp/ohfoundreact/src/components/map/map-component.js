import React, { useState, useEffect } from 'react';
import ReactMapGL, {Marker, Popup} from "react-map-gl";

import inseratService from '../../services/inseratService.js';

import SearchBarComponent from '../searchbar/searchbar-component.js';


function MapComponent() {
    const [inserate, setInserate] = useState(null);
    const [viewport, setViewport] = useState({
        latitude: 46.602493,
        longitude: 13.843117,
        width: "100vw",
        height: "100vh",
        zoom: 14
    });
    const [selectedItem, setSelectedItem] = useState(null);

    function handlePopupClose() {
      setSelectedItem(null);
    }

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

    const renderInserat = inserat => {
        console.log(selectedItem);
        return (
            <Marker
                key={inserat.in_id}
                latitude={inserat.coordinates[0]}
                longitude={inserat.coordinates[1]}
            >
                <button className="marker-btn"
                onClick={e => {
                    e.preventDefault();
                    setSelectedItem(inserat);
                }}
                >
                <img src="/icons/marker_icon_2.svg" alt="Lost Item" />
                </button>
            </Marker>
        );
    };
    function x(inserat) {
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
    }

  return (
    <div>
        
        <ReactMapGL
                {...viewport}
                mapboxApiAccessToken={process.env.REACT_APP_MAPBOX_TOKEN}
                mapStyle="mapbox://styles/pratljad/ck365eg270es51cpioo1agftc"
                onViewportChange={viewport => {
                setViewport(viewport);
                }}
            >
                <SearchBarComponent />
            {(inserate && inserate.length > 0) ? (
            inserate.map(inserat => renderInserat(inserat))
            ) : (
            <p>No inserate found</p>
            )}
            { selectedItem ? (
            <Popup 
                latitude={selectedItem.coordinates[0]} 
                longitude={selectedItem.coordinates[1]}
                onClose={handlePopupClose}
            >
                <div>
                    <h3>{selectedItem.in_typ}: {selectedItem.in_title}</h3>
                </div>
            </Popup>
            ) : null }
        </ReactMapGL>
    </div>
  );

}

export default MapComponent;
