using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ohFound_Client.bll
{
    class Item
    {
        public int Item_id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public DateTime Published { get; set; }
        public bool Marked_for_deletion { get; set; }

        public static int NextID = 1;

        public Item(int item_id, string title, string description, DateTime published, bool marked_for_deletion)
        {
            Item_id = item_id;
            Title = title;
            Description = description;
            Published = published;
            Marked_for_deletion = marked_for_deletion;

            NextID++;
        }
    }
}
