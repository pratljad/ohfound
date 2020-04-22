DROP TRIGGER IF EXISTS user_before_insert;

Delimiter //

CREATE TRIGGER user_before_insert
	BEFORE INSERT ON `OHFOUND`.User FOR EACH ROW
    
    BEGIN
    IF (new.Vorname = '' || new.Nachname = '' || new.Email = '' || new.Passwort = '') 
    THEN
		CALL `'Cannot add User: Nichts darf leer sein'`;
    END IF;
    END; //
    
 Delimiter ;   
    