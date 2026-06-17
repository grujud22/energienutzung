# Energienutzung in Österreich

A Spring Boot REST API serving Austrian energy usage data, broken down by year, region, sector, and fuel type. Data originates from [Statistik Austria / StatCube](https://statcube.at/statistik.at/ext/statcube/jsf/tableView/tableView.xhtml) and is loaded either from pre-converted JSON or directly from raw CSV files.

## Data Structure

Energy values are stored in GWh (gigawatt-hours) and may not be `null`

**Example JSON snippet:**
```json
[
  {
    "year": {
      "year": 2020
    },
    "fuel": {
      "fuelName": "Hard coal",
      "electrochemicalPurposes": 0.0,
      "spaceAndWaterHeating": 28.4,
      "stationaryEngines": 6.2,
      "processHeatBelow200c": 42.1,
      "processHeatAbove200c": 215.6,
      "lightingAndComputing": 0.0,
      "traction": 0.0
    },
    "region": {
      "regionName": "Styria"
    },
    "sector": {
      "sectorName": "Iron and steel"
    }
  }
]
```

## Data Ingestion

On startup, the application loads data via one of two modes controlled by `CSVToJson.READ_CSV`:

- **CSV mode** (`READ_CSV = true`): Reads raw `.csv` files from `resources/2005-2024/`, parses region columns, sector rows, and fuel sub-rows, and persists everything directly to the database.
- **JSON mode** (`READ_CSV = false`): Reads a pre-converted `data.json` from the classpath and deserializes it into the entity hierarchy.

## API Endpoints

All endpoints are under `/energienutzung`.

| Method | Path | Description |
|--------|------|-------------|
| GET | `/years/` | All years with full nested data |

Planned endpoints (total consumption aggregations):

- By sector → by year → by fuel
- By sector → by fuel
- By year → by fuel
- By fuel

## Collaboration

This service provides data to two downstream teams:

- **Marcel & Joshi** – consume region/sector breakdowns
- **Gabriel & Felix** – consume fuel-type aggregations

## Tech Stack

- Java 21 + Spring Boot
- Spring Data JPA (Hibernate)
- Lombok
- Jackson (JSON deserialization)
- H2 / relational DB (via JPA)
