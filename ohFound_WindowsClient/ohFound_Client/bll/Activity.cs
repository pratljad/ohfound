using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ohFound_Client.bll
{
    class Activity
    {
        public int Activity_id { get; set; }
        public string Category { get; set; }
        public int Account_id { get; set; }
        public string Account_name { get; set; }

        public static int NextID = 1;

        public Activity(int activitiy_id, string category, int account_id, string account_name)
        {
            Activity_id = activitiy_id;
            Category = category;
            Account_id = account_id;
            Account_name = account_name;

            NextID++;
        }
    }
}
