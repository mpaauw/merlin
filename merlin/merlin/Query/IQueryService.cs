using merlin.Common;
using System;
using System.Collections.Generic;
using System.Text;

namespace merlin.Query
{
    public interface IQueryService
    {
        public double GetLastTradePrice(AssetType assetType, BaseCurrency baseCurrency, string symbol);
    }
}
