using ohFound_Client.bll;
using ohFound_Client.dal;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace ohFound_Client
{
    /// <summary>
    /// Interaction logic for Löschanfragen.xaml
    /// </summary>
    public partial class Löschanfragen : UserControl
    {
        private DatabaseManager db = null;
        private ObservableCollection<Item> col_Items = null;

        public Löschanfragen()
        {
            InitializeComponent();
            InitializeMyComponents();
        }

        private async void InitializeMyComponents()
        {
            db = DatabaseManager.GetInstance();

            col_Items = await db.GETitems();
            /*foreach(Item item in col_Items)
            {
                if (item.Marked_for_deletion == false)
                {
                    col_Items.Remove(item);
                }
            }*/
            dg_Items.DataContext = col_Items;
        }

        private void Fertig_Click(object sender, RoutedEventArgs e)
        {
            MainWindow main = new MainWindow();

            main.Show();
            var myWindow = Window.GetWindow(this);
            myWindow.Close();
        }

        private async void Accept_Click(object sender, RoutedEventArgs e)
        {
            Item selected_item = (Item) dg_Items.SelectedItem;
            await db.DELETEitem(selected_item.Item_id);

            col_Items = await db.GETitems();
            /*foreach (Item item in col_Items)
            {
                if (item.Marked_for_deletion == false)
                {
                    col_Items.Remove(item);
                }
            }*/
            dg_Items.DataContext = col_Items;
        }
    }
}
