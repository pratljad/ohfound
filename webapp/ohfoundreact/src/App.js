import React, { useState, useEffect } from "react";

// SERVICES
import userService from './services/userService';
import LocationComponent from './components/location/location-component';
import InseratDisplayComponent from './components/inserat/inserat-display-component';
import FreigabeDisplayComponent from './components/freigabe/freigabe-display-component';
import ArtikelDisplayComponent from './components/artikel/artikel-display-component';
import MapComponent from './components/map/map-component.js';

function App() {
  const [users, setUsers] = useState(null);

  useEffect(() => {
    if(!users) {
      getUsers();
    }
  })

  const getUsers = async () => {
    let res = await userService.getAllUsers();
    console.log(res);
    setUsers(res);
  }

  const renderUser = user => {
    return (
      <li key={user.u_id} className="list__item product">
        <h3 className="product__name">{user.u_name}</h3>
        <p className="product__description">any user description</p>
      </li>
    );
  };

  function x(inserat) {
    return (
    <ul className="list">
        {(users && users.length > 0) ? (
          users.map(user => renderUser(user))
        ) : (
          <p>No users found</p>
        )}
      </ul>
    );
  }
  return (
    <div className="App">
      
      
      <MapComponent />
    </div>
  );
}

export default App;