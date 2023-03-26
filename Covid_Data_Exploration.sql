

SELECT *
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths`
WHERE continent IS NOT null
ORDER BY 3,4

-- SELECT *
-- FROM `covid-data-analysis-379919.Covid_Data.Covid_Vaccinations`
-- ORDER BY 3,4

-- Select Data that we are going to be using

SELECT Location, date, total_cases, new_cases, total_deaths, population
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths`
WHERE continent IS NOT null
ORDER BY 1, 2

-- Looking at Total Cases vs Total Deaths
-- Shows the likelihood of dying if you contract covid in your country
SELECT Location, date, total_cases, total_deaths, (total_deaths/total_cases)*100 AS DeathPercentage
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths`
WHERE location LIKE '%States%'
AND continent IS NOT null
ORDER BY 1, 2


-- Looking at the Total Cases vs the Population
-- Shows what percentage of population that caught Covid

SELECT Location, date, total_cases, population, (total_cases/population)*100 AS InfectionPercentage
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths`
WHERE location LIKE '%States%'
AND continent IS NOT null
ORDER BY 1, 2


-- Looking at countries with Highest Infection Rate compared to population

SELECT Location, population, MAX(total_cases) AS HighestInfectionCount, MAX((total_cases/population))*100 AS
 PercentPopulationInfected
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths`
-- WHERE location LIKE '%States%'
WHERE continent IS NOT null
GROUP BY Location, population
ORDER BY PercentPopulationInfected DESC


-- Show the countries with the Highest Death Count per population

SELECT Location, MAX(cast(total_deaths AS int)) AS TotalDeathCount
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths`
-- WHERE location LIKE '%States%'
WHERE continent IS NOT null
GROUP BY Location
ORDER BY TotalDeathCount DESC


-- LET'S BREAK THINGS DOWN BY CONTINENT


-- Showing the contnients with the highest death count per population

SELECT continent, MAX(cast(total_deaths AS int)) AS TotalDeathCount
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths`
-- WHERE location LIKE '%States%'
WHERE continent IS NOT null
GROUP BY continent
ORDER BY TotalDeathCount DESC



-- Global Numbers

SELECT date, SUM(new_cases) AS total_cases, SUM(cast(new_deaths AS int)) AS total_deaths, 
  SUM(cast(new_deaths AS int))/SUM(new_cases)*100 AS DeathPercentage
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths`
-- WHERE location LIKE '%States%'
WHERE continent IS NOT null
GROUP By date
ORDER BY 1, 2

SELECT SUM(new_cases) AS total_cases, SUM(cast(new_deaths AS int)) AS total_deaths, 
  SUM(cast(new_deaths AS int))/SUM(new_cases)*100 AS DeathPercentage
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths`
-- WHERE location LIKE '%States%'
WHERE continent IS NOT null
-- GROUP By date
ORDER BY 1, 2


-- Looking at Total Population vs Vaccinations

SELECT dea.continent, dea.location, dea.date, dea.population, vac.new_vaccinations
  , SUM(cast(vac.new_vaccinations AS int)) OVER (PARTITION BY dea.location ORDER BY dea.location, dea.date)
  AS RollingPeopleVaccinated
  -- , (RollingPeopleVaccinated/dea.population)*100
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths` dea
JOIN `covid-data-analysis-379919.Covid_Data.Covid_Vaccinations` vac
  ON dea.location = vac.location
  AND dea.date = vac.date
WHERE dea.continent IS NOT null
ORDER BY 2, 3


-- USE CTE

WITH PopvsVac AS
(
SELECT dea.continent, dea.location, dea.date, dea.population, vac.new_vaccinations
  , SUM(cast(vac.new_vaccinations AS int)) OVER (PARTITION BY dea.location ORDER BY dea.location, dea.date)
  AS RollingPeopleVaccinated
  -- , (RollingPeopleVaccinated/dea.population)*100
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths` dea
JOIN `covid-data-analysis-379919.Covid_Data.Covid_Vaccinations` vac
  ON dea.location = vac.location
  AND dea.date = vac.date
WHERE dea.continent IS NOT null
-- ORDER BY 2, 3
)
SELECT *, (RollingPeopleVaccinated/population)*100
FROM PopvsVac


-- Creating View to store data for later visualizations

-- CREATE View PercentPopulationVaccinated AS 
SELECT dea.continent, dea.location, dea.date, dea.population, vac.new_vaccinations
  , SUM(cast(vac.new_vaccinations AS int)) OVER (PARTITION BY dea.location ORDER BY dea.location, dea.date)
  AS RollingPeopleVaccinated
  -- , (RollingPeopleVaccinated/dea.population)*100
FROM `covid-data-analysis-379919.Covid_Data.Covid_Deaths` dea
JOIN `covid-data-analysis-379919.Covid_Data.Covid_Vaccinations` vac
  ON dea.location = vac.location
  AND dea.date = vac.date
WHERE dea.continent IS NOT null
-- ORDER BY 2, 3
