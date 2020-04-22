using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ohFound_Client.bll
{
    class Request
    {
        public int Request_id { get; set; }
        public int Useraccount_id { get; set; }
        public int Organizationaccount_id { get; set; }
        public int Item_id { get; set; }
        public bool Denied { get; set; }
        public bool Opposed { get; set; }
        public bool Approved { get; set; }

        public static int NextID = 1;

        public Request(int request_id, int useraccount_id, int organizationaccount_id, int item_id, bool denied, bool opposed, bool approved)
        {
            Request_id = request_id;
            Useraccount_id = useraccount_id;
            Organizationaccount_id = organizationaccount_id;
            Item_id = item_id;
            Denied = denied;
            Opposed = opposed;
            Approved = approved;

            NextID++;
        }
    }
}
