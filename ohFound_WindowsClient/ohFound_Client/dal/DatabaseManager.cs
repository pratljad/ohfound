using System;
using System.Threading.Tasks;
using System.Collections.ObjectModel;
using ohFound_Client.bll;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Net;

namespace ohFound_Client.dal
{
    class DatabaseManager
    {
        private static readonly HttpClient client = new HttpClient();   //vl das read-only weg?
        private static DatabaseManager dbm_reference = null;

        private DatabaseManager()
        {
            // Update port # in the following line.
            client.BaseAddress = new Uri("http://10.0.0.32:8080/OhFound_Webservice/");
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }

        public static DatabaseManager GetInstance()
        {
            if (dbm_reference == null)
            {
                dbm_reference = new DatabaseManager();
            }

            return dbm_reference;
        }

        public async Task<ObservableCollection<Account>> GETaccounts()
        {
            ObservableCollection<Account> accounts = null;
            HttpResponseMessage response = await client.GetAsync("api/accounts");

            if (response.IsSuccessStatusCode)
            {
                accounts = await response.Content.ReadAsAsync<ObservableCollection<Account>>();
            }
            return accounts;
        }

        public async void POSTaccount(Account account)
        {
            HttpResponseMessage response = await client.PostAsJsonAsync("api/accounts", account);
            response.EnsureSuccessStatusCode();
        }

        public async void UPDATEaccount(Account account)
        {
            HttpResponseMessage response = await client.PutAsJsonAsync($"api/accounts/{account.Account_id}", account);
            response.EnsureSuccessStatusCode();
        }

        public async Task<HttpStatusCode> DELETEaccount(int id)
        {
            HttpResponseMessage response = await client.DeleteAsync($"api/accounts/{id}");
            return response.StatusCode;
        }

        public async Task<ObservableCollection<Activity>> GETactivities()
        {
            ObservableCollection<Activity> activities = null;
            HttpResponseMessage response = await client.GetAsync("api/activities");

            if (response.IsSuccessStatusCode)
            {
                activities = await response.Content.ReadAsAsync<ObservableCollection<Activity>>();
            }
            return activities;
        }

        public async void POSTactivity(Activity activity)
        {
            HttpResponseMessage response = await client.PostAsJsonAsync("api/activities", activity);
            response.EnsureSuccessStatusCode();
        }

        public async void UPDATEactivity(Activity activity)
        {
            HttpResponseMessage response = await client.PutAsJsonAsync($"api/activities/{activity.Activity_id}", activity);
            response.EnsureSuccessStatusCode();
        }

        public async Task<HttpStatusCode> DELETEactivity(int id)
        {
            HttpResponseMessage response = await client.DeleteAsync($"api/activities/{id}");
            return response.StatusCode;
        }

        public async Task<ObservableCollection<Item>> GETitems()
        {
            ObservableCollection<Item> items = null;
            HttpResponseMessage response = await client.GetAsync("api/items");

            if (response.IsSuccessStatusCode)
            {
                items = await response.Content.ReadAsAsync<ObservableCollection<Item>>();
            }
            return items;
        }

        public async void POSTitem(Item items)
        {
            HttpResponseMessage response = await client.PostAsJsonAsync("api/items", items);
            response.EnsureSuccessStatusCode();
        }

        public async void UPDATEitem(Item items)
        {
            HttpResponseMessage response = await client.PutAsJsonAsync($"api/items/{items.Item_id}", items);
            response.EnsureSuccessStatusCode();
        }

        public async Task<HttpStatusCode> DELETEitem(int id)
        {
            HttpResponseMessage response = await client.DeleteAsync($"api/items/{id}");
            return response.StatusCode;
        }

        public async Task<ObservableCollection<Request>> GETrequests()
        {
            ObservableCollection<Request> requests = null;
            HttpResponseMessage response = await client.GetAsync("api/requests");

            if (response.IsSuccessStatusCode)
            {
                requests = await response.Content.ReadAsAsync<ObservableCollection<Request>>();
            }
            return requests;
        }

        public async void POSTrequest(Request request)
        {
            HttpResponseMessage response = await client.PostAsJsonAsync("api/requests", request);
            response.EnsureSuccessStatusCode();
        }

        public async void UPDATErequest(Request request)
        {
            HttpResponseMessage response = await client.PutAsJsonAsync($"api/requests/{request.Request_id}", request);
            response.EnsureSuccessStatusCode();
        }

        public async Task<HttpStatusCode> DELETErequest(int id)
        {
            HttpResponseMessage response = await client.DeleteAsync($"api/requests/{id}");
            return response.StatusCode;
        }
    }
}
