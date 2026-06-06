**Inventory Search Service
Overview**

This project provides a scalable and efficient search system for inventory management. It is designed to quickly retrieve product and stock information across large datasets while supporting flexible search queries and future growth.

**Search Approach:
Primary Approach: Database Search**

The first and primary approach for inventory search is direct database querying. This approach ensures:

* Strong consistency with the source of truth
* Simple and reliable retrieval

* Easy integration with existing relational inventory systems

**Recommended Approach: NoSQL Search Engine**

For improved scalability and advanced search capabilities, a NoSQL-based search solution is recommended.

**Recommended Tool: Elasticsearch**

We recommend using Elasticsearch as the primary search engine for advanced inventory search functionality.

**Why Elasticsearch?**
* Full-text search capabilities
* High-speed query performance on large datasets
* Scalable distributed architecture
* Supports fuzzy search and partial matching
* Powerful filtering and aggregation features

**Currunt Implementation:** **Using MySQL Database**
### Design
* Data stored in normalized relational tables.
* Search performed using:

    * Indexed columns
    * WHERE clauses
    * ORDER BY
    * LIMIT/OFFSET pagination
### Example Query

```sql
SELECT *
FROM products
WHERE category = ?
  AND category = ? 
ORDER BY created_at DESC
LIMIT 20 OFFSET 0;
```

### Pros

#### Simpler Architecture

* Single datastore.
* Easier deployment and maintenance.
* Fewer moving parts.

#### Strong Consistency

* Read and write operations use the same source of truth.
* No additional infrastructure required.

#### Lower Operational Cost
* no need to maintain any other external search engines

### Cons

#### Limited Search Capabilities

* Not optimized for advanced text search.

##### **Problems in my desinged those still needs improvements**
Growing Spring Data **Specification Class**
In the current implementation, the search logic is built using Spring Data JPA Specification. Over time, this class has started to grow significantly as more filters are added.

**Solution 1: Modular Specification Pattern**
* CategorySpecification
* PriceRangeSpecification
* AvailabilitySpecification
* KeywordSpecification

**Solution 2: Strategy Pattern**
public interface ProductFilterStrategy;
* CategoryFilter implements ProductFilterStrategy
* Availability implements ProductFilterStrategy


### High-Level Flow
Client (UI / Postman) 

↓

InventorySearchController

↓

Request Validation (@Valid + Custom Validators)

↓
  ->  (Invalid → GlobalExceptionHandler → 400 Error Response)
    
(Valid)
↓

InventoryService

↓

Build Pageable (Pagination + Sorting)
↓
InventorySpecification (Dynamic Query Builder)

↓

InventoryRepository (JpaSpecificationExecutor)

↓

Database (Inventory Table)

↓

Page<Inventory> Result

↓

InventoryMapper (Entity → DTO Conversion)

↓

InventorySearchResponseDto Builder

↓

HTTP Response (200 OK)

**Example cURL**

curl -X POST http://localhost:8080/api/inventory/search \
-H "Content-Type: application/json" \
-d '{
"keyword": "iphone",
"category": "Electronics",
"inStock": true
}'

**Swagger:

UI: **http://localhost:8080/swagger-ui/index.html**

API spec: **http://localhost:8080/v3/api-docs**