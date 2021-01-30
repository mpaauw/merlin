using merlin.Common;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;

namespace merlin.Query
{
    public class QueryService : IQueryService
    {
        private HttpClient httpClient;

        public QueryService()
        {
            httpClient = new HttpClient();
        }

        public double GetLastTradePrice(AssetType assetType, BaseCurrency baseCurrency, string symbol)
        {
            switch (assetType)
            {
                case AssetType.Crypto:
                    GetLastTradePriceOfCryptoAsset(baseCurrency, symbol);
                    break;
                default:
                    break;
            }

            return 0.0;
        }

        private void GetLastTradePriceOfCryptoAsset(BaseCurrency baseCurrency, string symbol)
        {
            try
            {
                var response = httpClient.GetAsync("https://api.coinlore.net/api/ticker/?id=80").Result;
                string rawResponse = response.Content.ReadAsStringAsync().Result;
                Console.WriteLine(rawResponse);
            }
            catch (Exception ex)
            {
                Console.WriteLine("oops!");
            }
        }
    }
}
