using merlin.Query;
using System;
using System.Timers;

namespace merlin
{
    class Program
    {
        static void Main(string[] args)
        {
            // TODO: Remove test code:
            System.Diagnostics.Stopwatch stopwatch = System.Diagnostics.Stopwatch.StartNew();
            IQueryService queryService = new QueryService();
            queryService.GetLastTradePrice(Common.AssetType.Crypto, Common.BaseCurrency.USD, "ETH-USD");
            stopwatch.Stop();
            long elapsedTimeMs = stopwatch.ElapsedMilliseconds;
            Console.WriteLine("TOTAL EXECUTION TIME: {0}ms\nHIT ENTER TO TERMINATE...", elapsedTimeMs);
            Console.ReadLine();
        }

    }
}
