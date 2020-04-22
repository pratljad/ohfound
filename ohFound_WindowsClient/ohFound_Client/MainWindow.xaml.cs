using System;
using System.Collections.Generic;
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
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void GenehmigeRegistrierungen_Click(object sender, RoutedEventArgs e)
        {
            Registrierungen myUI = new Registrierungen();

            mainGrid.Children.Clear();
            mainGrid.Children.Add(myUI);
        }

        private void GenehmigeLöschanfragen_Click(object sender, RoutedEventArgs e)
        {
            Löschanfragen myUI = new Löschanfragen();

            mainGrid.Children.Clear();
            mainGrid.Children.Add(myUI);
        }

        private void ÜberwacheAktivitäten_Click(object sender, RoutedEventArgs e)
        {
            Aktivitäten myUI = new Aktivitäten();

            mainGrid.Children.Clear();
            mainGrid.Children.Add(myUI);
        }

        private void ÜberprüfeAblehnungen_Click(object sender, RoutedEventArgs e)
        {
            Wiederrufungen myUI = new Wiederrufungen();

            mainGrid.Children.Clear();
            mainGrid.Children.Add(myUI);
        }
    }
}
