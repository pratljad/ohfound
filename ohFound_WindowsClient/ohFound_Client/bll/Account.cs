using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ohFound_Client.bll
{
    class Account
    {
        public int Account_id { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }
        public string Firstname { get; set; }
        public string Lastname { get; set; }
        public string Organizationname { get; set; }
        public bool Locked { get; set; }
        public int Suspicion_level { get; set; }

        public static int NextID = 1;

        public Account(int account_id, string username, string password, string firstname, string lastname, string organizationname, bool locked, int suspicion_level)
        {
            Account_id = account_id;
            Username = username;
            Password = password;
            Firstname = firstname;
            Lastname = lastname;
            Organizationname = organizationname;
            Locked = locked;
            Suspicion_level = suspicion_level;

            NextID++;
        }
    }
}
