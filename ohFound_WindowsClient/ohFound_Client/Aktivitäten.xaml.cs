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
    /// Interaction logic for Aktivitäten.xaml
    /// </summary>
    public partial class Aktivitäten : UserControl
    {
        private DatabaseManager db = null;
        private ObservableCollection<Activity> col_Activities = null;
        private ObservableCollection<Account> col_Accounts = null;

        public Aktivitäten()
        {
            InitializeComponent();
            InitializeMyComponents();
        }

        private async void InitializeMyComponents()
        {
            db = DatabaseManager.GetInstance();

            col_Activities = await db.GETactivities();
            col_Accounts = await db.GETaccounts();

            /*foreach (Account account in col_Accounts)
            {
                if (account.Suspicion_level == 0)
                {
                    col_Accounts.Remove(account);
                }
            }*/

            dg_activity.DataContext = col_Activities;
            dg_accounts.DataContext = col_Accounts;
        }

        private void Fertig_Click(object sender, RoutedEventArgs e)
        {
            MainWindow main = new MainWindow();

            main.Show();
            var myWindow = Window.GetWindow(this);
            myWindow.Close();
        }

        private async void Increase_Click(object sender, RoutedEventArgs e)
        {
            Activity selected_activity = (Activity) dg_activity.SelectedItem;
            foreach (Account account in col_Accounts)
            {
                if (account.Account_id == selected_activity.Account_id)
                {
                    account.Suspicion_level++;
                    db.UPDATEaccount(account);
                }
            }

            col_Activities = await db.GETactivities();
            col_Accounts = await db.GETaccounts();

            /*foreach (Account account in col_Accounts)
            {
                if (account.Suspicion_level == 0)
                {
                    col_Accounts.Remove(account);
                }
            }*/

            dg_activity.DataContext = col_Activities;
            dg_accounts.DataContext = col_Accounts;
        }

        private async void Decrease_Click(object sender, RoutedEventArgs e)
        {
            Activity selected_activity = (Activity)dg_activity.SelectedItem;
            foreach (Account account in col_Accounts)
            {
                if (account.Account_id == selected_activity.Account_id)
                {
                    account.Suspicion_level--;
                    db.UPDATEaccount(account);
                }
            }

            col_Activities = await db.GETactivities();
            col_Accounts = await db.GETaccounts();

            /*foreach (Account account in col_Accounts)
            {
                if (account.Suspicion_level == 0)
                {
                    col_Accounts.Remove(account);
                }
            }*/

            dg_activity.DataContext = col_Activities;
            dg_accounts.DataContext = col_Accounts;
        }

        private async void LockAccount_Click(object sender, RoutedEventArgs e)
        {
            Account selected_account = (Account) dg_accounts.SelectedItem;
            selected_account.Locked = true;
            db.UPDATEaccount(selected_account);

            col_Accounts = await db.GETaccounts();

            /*foreach (Account account in col_Accounts)
            {
                if (account.Suspicion_level == 0)
                {
                    col_Accounts.Remove(account);
                }
            }*/

            dg_accounts.DataContext = col_Accounts;
        }
    }
}
